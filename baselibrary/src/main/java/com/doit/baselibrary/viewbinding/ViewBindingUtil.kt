@file:JvmName("ViewBindingUtil")
@file:Suppress("UNCHECKED_CAST")

package com.doit.baselibrary.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.doit.baselibrary.BaseActivity
import com.doit.baselibrary.BaseFragment
import java.lang.reflect.ParameterizedType

/**
 * @author chends create on 2021/10/13.
 */
@JvmName("inflateWithGeneric")
fun <VB : ViewBinding> Any.inflateBinding(layoutInflater: LayoutInflater): VB =
    withGenericBindingClass(this) {
        it.getMethod("inflate", LayoutInflater::class.java).invoke(null, layoutInflater) as VB
    }

@JvmName("inflateWithGeneric")
fun <VB : ViewBinding> Any.inflateBinding(parent: ViewGroup): VB =
    withGenericBindingClass(this) {
        inflateBinding(LayoutInflater.from(parent.context), parent, false)
    }

@JvmName("inflateWithGeneric")
fun <VB : ViewBinding> Any.inflateBinding(
    layoutInflater: LayoutInflater, parent: ViewGroup?, attachToParent: Boolean
): VB =
    withGenericBindingClass(this) { clazz ->
        clazz.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null, layoutInflater, parent, attachToParent) as VB
    }

private fun <VB : ViewBinding> withGenericBindingClass(any: Any, block: (Class<VB>) -> VB): VB {
    var index = 0
    while (true) {
        try {
            return block.invoke(any.findGenericBindingClass(index))
        } catch (e: NoSuchMethodException) {
            index++
        }
    }
}

private fun <VB : ViewBinding> Any.findGenericBindingClass(index: Int): Class<VB> {
    var type = javaClass.genericSuperclass
    val clsFg: Class<*> = BaseFragment::class.java
    val clsAct: Class<*> = BaseActivity::class.java
    while (true) {
        if (type is ParameterizedType) {
            val rawClass = type.rawType as Class<*>
            if (rawClass != clsFg && rawClass != clsAct) {
                if (index < type.actualTypeArguments.size) {
                    return type.actualTypeArguments[index] as Class<VB>
                } else {
                    type = rawClass.genericSuperclass
                }
            } else {
                break
            }
        } else {
            if (type != clsFg && type != clsAct) {
                type = (type as Class<*>).genericSuperclass
            } else {
                break
            }
        }
    }
    throw IllegalArgumentException("There is no generic of ViewBinding.")
}