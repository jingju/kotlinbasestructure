package com.doit.base.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<V> : ViewModel(), IBaseViewModel<V> {
}