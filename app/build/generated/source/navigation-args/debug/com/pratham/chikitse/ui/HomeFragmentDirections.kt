package com.pratham.chikitse.ui

import android.os.Bundle
import androidx.navigation.NavDirections
import com.pratham.chikitse.R
import kotlin.Int

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToStepFragment(
    public val emergencyId: Int = 0,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_stepFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("emergencyId", this.emergencyId)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToStepFragment(emergencyId: Int = 0): NavDirections =
        ActionHomeFragmentToStepFragment(emergencyId)
  }
}
