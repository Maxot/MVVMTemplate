package com.maxot.mvvmtemplate.data

import com.maxot.mvvmtemplate.data.local.pref.PreferenceHelper
import com.maxot.mvvmtemplate.data.remote.ApiHelper

interface DataManager: ApiHelper, PreferenceHelper {
}