# FailingInstantSerialisation

A code example where serializing an Instant-Object fails with:
```
java.lang.IllegalStateException: Class Instant have constructor parameters which are not properties and therefore it is not serializable automatically
	at org.jetbrains.kotlinx.serialization.compiler.backend.common.SerializerCodegen.checkSerializability(SerializerCodegen.kt:28)
	at org.jetbrains.kotlinx.serialization.compiler.backend.common.SerializerCodegen.generateSerializableClassPropertyIfNeeded(SerializerCodegen.kt:101)
	at org.jetbrains.kotlinx.serialization.compiler.backend.common.SerializerCodegen.generate(SerializerCodegen.kt:34)
	at org.jetbrains.kotlinx.serialization.compiler.backend.ir.SerializerIrGenerator$Companion.generate(SerializerIrGenerator.kt:626)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializerClassLowering.lower(SerializationLoweringExtension.kt:53)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt$runOnFileInOrder$1.visitClass(SerializationLoweringExtension.kt:37)
	at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitClass(IrElementVisitorVoid.kt:44)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt$runOnFileInOrder$1.visitClass(SerializationLoweringExtension.kt:31)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt$runOnFileInOrder$1.visitClass(SerializationLoweringExtension.kt:31)
	at org.jetbrains.kotlin.ir.declarations.IrClass.accept(IrClass.kt:56)
	at org.jetbrains.kotlin.ir.declarations.impl.IrFileImpl.acceptChildren(IrFileImpl.kt:66)
	at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoidKt.acceptChildrenVoid(IrElementVisitorVoid.kt:275)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt$runOnFileInOrder$1.visitElement(SerializationLoweringExtension.kt:33)
	at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitPackageFragment(IrElementVisitorVoid.kt:30)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt$runOnFileInOrder$1.visitPackageFragment(SerializationLoweringExtension.kt:31)
	at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitFile(IrElementVisitorVoid.kt:37)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt$runOnFileInOrder$1.visitFile(SerializationLoweringExtension.kt:31)
	at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitFile(IrElementVisitorVoid.kt:38)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt$runOnFileInOrder$1.visitFile(SerializationLoweringExtension.kt:31)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt$runOnFileInOrder$1.visitFile(SerializationLoweringExtension.kt:31)
	at org.jetbrains.kotlin.ir.declarations.impl.IrFileImpl.accept(IrFileImpl.kt:63)
	at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoidKt.acceptVoid(IrElementVisitorVoid.kt:271)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtensionKt.runOnFileInOrder(SerializationLoweringExtension.kt:31)
	at org.jetbrains.kotlinx.serialization.compiler.extensions.SerializationLoweringExtension.generate(SerializationLoweringExtension.kt:71)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory$convertToIr$1.invoke(JvmIrCodegenFactory.kt:120)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory$convertToIr$1.invoke(JvmIrCodegenFactory.kt:116)
	at org.jetbrains.kotlin.psi2ir.Psi2IrTranslator.generateModuleFragment(Psi2IrTranslator.kt:91)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.convertToIr(JvmIrCodegenFactory.kt:140)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.convertToIr$default(JvmIrCodegenFactory.kt:66)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.generateModule(JvmIrCodegenFactory.kt:61)
	at org.jetbrains.kotlin.codegen.KotlinCodegenFacade.compileCorrectFiles(KotlinCodegenFacade.java:35)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.generate(KotlinToJVMBytecodeCompiler.kt:592)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:212)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli$default(KotlinToJVMBytecodeCompiler.kt:155)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:169)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:52)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:88)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:44)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:98)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:386)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:110)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileIncrementally(IncrementalCompilerRunner.kt:303)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl$rebuild(IncrementalCompilerRunner.kt:99)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl(IncrementalCompilerRunner.kt:124)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compile(IncrementalCompilerRunner.kt:74)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.execIncrementalCompiler(CompileServiceImpl.kt:607)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.access$execIncrementalCompiler(CompileServiceImpl.kt:96)
	at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1659)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:359)
	at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
	at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:562)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:796)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:677)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:676)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:834)
  
```

  
 Requires Java 11
 
  
