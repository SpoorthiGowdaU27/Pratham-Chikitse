package com.pratham.chikitse.ui

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class StepFragmentArgs(
  public val emergencyId: Int = 0,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("emergencyId", this.emergencyId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("emergencyId", this.emergencyId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): StepFragmentArgs {
      bundle.setClassLoader(StepFragmentArgs::class.java.classLoader)
      val __emergencyId : Int
      if (bundle.containsKey("emergencyId")) {
        __emergencyId = bundle.getInt("emergencyId")
      } else {
        __emergencyId = 0
      }
      return StepFragmentArgs(__emergencyId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): StepFragmentArgs {
      val __emergencyId : Int?
      if (savedStateHandle.contains("emergencyId")) {
        __emergencyId = savedStateHandle["emergencyId"]
        if (__emergencyId == null) {
          throw IllegalArgumentException("Argument \"emergencyId\" of type integer does not support null values")
        }
      } else {
        __emergencyId = 0
      }
      return StepFragmentArgs(__emergencyId)
    }
  }
}
