# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/nmo/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

############################################
###         AUTOPARCEL + JACKSON
############################################
-dontwarn org.w3c.dom.**
# try to keep jackson running with introspection.
-keep @interface com.fasterxml.jackson.** { *; }
-keepclassmembernames class com.fasterxml.jackson.** { <fields>; }
-keepclassmembers public final enum org.codehaus.jackson.annotate.JsonAutoDetect$Visibility { public static final org.codehaus.jackson.annotate.JsonAutoDetect$Visibility *; }
# keep jackson annotations JsonDeserialize,  JsonCreator, JsonProperty...
-keepclassmembers @com.fasterxml.jackson.databind.annotation.JsonDeserialize class *
-keepclassmembers, allowobfuscation class * { @com.fasterxml.jackson.annotation.JsonCreator *; }
-keepclassmembers, allowobfuscation class * { @com.fasterxml.jackson.annotation.JsonProperty *; }
# keep class implementing JsonTypeInfo
-keep, allowobfuscation class * implements @com.fasterxml.jackson.annotation.JsonTypeInfo * { *; }
# keep builder interface with the build method.
-keep, allowobfuscation interface **$Builder { *; }
-keepclassmembernames interface **$Builder { ** build(); }
-keep, allowobfuscation class **$Builder { *; }
# keep enum values
-keepclassmembers enum * { *; }
# keep generic in signature (useful for list)
-keepattributes Signature