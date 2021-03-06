package com.ghataa.fbremoteconfig.data

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View
import android.widget.Toast
import com.ghataa.fbremoteconfig.R
import com.ghataa.fbremoteconfig.util.RemoteConfigUtil

class MainViewModel : ViewModel() {

    val buttonText = ObservableField<FalconTarget>(FalconTarget.TATOOINE)

    fun onMainButtonClick(view: View) {
        val targetStringResId = if (RemoteConfigUtil.targetIsTatooine()) R.string.tatooine else R.string.death_star

        Toast.makeText(view.context,
                view.context.getString(R.string.target_toast_text, view.context.getString(targetStringResId)),
                Toast.LENGTH_SHORT).show()
    }

    fun setButtonText(falconTarget: FalconTarget) {
        buttonText.set(falconTarget)
    }
}

enum class FalconTarget {
    TATOOINE,
    DEATH_STAR
}
