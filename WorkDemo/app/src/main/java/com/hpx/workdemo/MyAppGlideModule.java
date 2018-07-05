package com.hpx.workdemo;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/** https://juejin.im/entry/5924f28eda2f60005d7725b2
 *
 * Glide 4.0 使用：
 * dependencies {
        compile 'com.github.bumptech.glide:glide:4.1.1'
        annotationProcessor 'com.github.bumptech.glide:compiler:4.1.1'
    }
 *
 *
 * 要触发 Glide 4.0  API生成，需要在应用程序中包含一个AppGlideModule实现：
 *
 * 注意：此类需要在程序主包名下，不能在次级包内
 * AppGlideModule实现必须始终注释@GlideModule
 *
 * 之后 clean / make project，生成 GlideApp
 *
 * API在与应用程序AppGlideModule提供的实现相同的包中生成，
 * 并且GlideApp默认命名。应用程序可以通过启动所有，
 * 加载GlideApp.with()而不是使用API Glide.with()：
 */
@GlideModule
public  class MyAppGlideModule extends AppGlideModule {
}
