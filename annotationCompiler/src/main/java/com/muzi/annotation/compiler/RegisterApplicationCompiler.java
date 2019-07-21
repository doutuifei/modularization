package com.muzi.annotation.compiler;

import com.google.auto.service.AutoService;
import com.muzi.annotation.AppConstants;
import com.muzi.annotation.RegisterApplicationPackage;
import com.muzi.annotation.annotation.RegisterApplication;
import com.muzi.annotation.enums.ThreadMode;
import com.muzi.annotation.interfaces.IRegisterApplication;
import com.muzi.annotation.utils.StringUtils;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Author: lipeng
 * Date: 2019/7/14
 * Email: lipeng@moyi365.com
 * Content:
 */
@AutoService(Processor.class)
public class RegisterApplicationCompiler extends AbstractProcessor {

    private Filer filer;
    private Messager messager;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        elementUtils = processingEnv.getElementUtils();
        messager = processingEnv.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new HashSet<>();
        set.add(RegisterApplication.class.getCanonicalName());
        return set;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations != null && !annotations.isEmpty()) {
            createSource(roundEnv.getElementsAnnotatedWith(RegisterApplication.class));
        }
        return false;
    }

    private void createSource(Set<? extends Element> elements) {
        TypeSpec.Builder typeSpecBuilder = null;
        MethodSpec.Builder methodBuilder = null;

        /**
         * source package name
         */
        String sourcePackageName = AppConstants.PACKAGE_NAME;

        for (Element element : elements) {
            if (element.getKind() != ElementKind.CLASS) {
                continue;
            }
            TypeElement typeElement = (TypeElement) element;
            PackageElement packageElement = elementUtils.getPackageOf(typeElement);

            if (typeSpecBuilder == null) {
                /**
                 * source file name
                 */
                String moduleName = StringUtils.captureName(packageElement.getSimpleName().toString());
                String sourceFileName = "Application$$" + moduleName;

                typeSpecBuilder = TypeSpec.classBuilder(sourceFileName)
                        .addModifiers(Modifier.PUBLIC)
                        .addSuperinterface(IRegisterApplication.class);
            }
            if (methodBuilder == null) {
                ClassName override = ClassName.get("java.lang", "Override");

                ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(
                        ClassName.get(List.class),
                        ClassName.get(RegisterApplicationPackage.class)
                );
                ParameterSpec rootParamSpec = ParameterSpec.builder(parameterizedTypeName, "list").build();
                methodBuilder = MethodSpec.methodBuilder("registerApplication")
                        .addModifiers(Modifier.PUBLIC)
                        .addParameter(rootParamSpec)
                        .addAnnotation(override);
            }

            /**
             * Application qualified name
             */
            String appQualifiedName = packageElement.getQualifiedName().toString() + "." + typeElement.getSimpleName();

            RegisterApplication registerApplication = typeElement.getAnnotation(RegisterApplication.class);

            int priority = registerApplication.priority();
            long delay = registerApplication.delay();
            ThreadMode threadMode = registerApplication.thread();

            ClassName RegisterApplicationPackageCN = ClassName.get(RegisterApplicationPackage.class);
            ClassName threadModeCN = ClassName.get(ThreadMode.class);

            methodBuilder.addStatement("list.add(new $T (\"" + appQualifiedName + "\"," + priority + "," + delay + ", $T." + threadMode + "))", RegisterApplicationPackageCN, threadModeCN);

        }
        if (typeSpecBuilder == null || methodBuilder == null) {
            return;
        }
        TypeSpec typeSpec = typeSpecBuilder
                .addMethod(methodBuilder.build())
                .build();
        JavaFile file = JavaFile.builder(sourcePackageName, typeSpec)
                .build();
        try {
            file.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
