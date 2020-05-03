#include <jni.h>

jstring Java_com_lahm_learndaemon_activity_JniActivity_sayHello(JNIEnv *env,jobject jobi) {

    return (*env)->NewStringUTF(env, "hello world jin");

}