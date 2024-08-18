# Add project-specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see:
#   http://developer.android.com/guide/developing/tools/proguard.html

# Preserve OSS Licenses Activity and related classes
-keep class com.google.android.gms.oss.licenses.** { *; }

# Keep inner classes of the OSS Licenses package
-keep class com.google.android.gms.oss.licenses.**$* { *; }

# Keep all methods and fields of the OSS Licenses classes
-keepclassmembers class com.google.android.gms.oss.licenses.** { *; }

# Keep method and field names (important if reflection is used)
-keepnames class com.google.android.gms.oss.licenses.** { *; }

# Keep annotations related to OSS Licenses
-keepattributes *Annotation*

# Preserve your application's classes that may interact with OSS licenses
-keep class artan.bajqinca.morgon_afton_dhikr.** { *; }

# Keep source file and line number information for debugging
-keepattributes SourceFile,LineNumberTable

# Uncomment this to hide the original source file name in stack traces.
#-renamesourcefileattribute SourceFile

# Uncomment the following if your project uses WebView with JavaScript.
# Specify the fully qualified class name to the JavaScript interface class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
