#include <jni.h>
#include <string>
#include <inttypes.h>

extern "C"
JNIEXPORT jint

JNICALL
Java_com_holomatic_myjni_MainActivity_stringFromJNI(
        JNIEnv *env,
        jint a/* this */) {
    std::string hello = "Hello from C++";
    std::string hello1 = "Hello from C";
    std::string hello2 = hello + hello1;

    jclass jclass1 = env->FindClass("");

    //传入class，方法的名称，方法的签名
    jmethodID jmethodID1 = env->GetMethodID(jclass1, "", "");

    //如果是方法的名称找不到

    if(jmethodID1==NULL){
        return 0;
    }

    //jint jint1=env->NewIntArray();

    jstring data = env->NewStringUTF("what wrong with you");

    jint length=env->GetStringLength(data);



    char buf[64];

    sprintf(buf, "%d",16);

    //return (*env)->NewStringUTF(env, buf);

    return length;

}
