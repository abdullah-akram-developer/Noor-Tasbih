package com.trihashstudio.noortasbih.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
class DhikrViewModel : ViewModel() {

    var selectedDhikr = mutableStateOf("Dhikr")
        private set

    fun setDhikr(name: String) {
        selectedDhikr.value = name
        // whenever user changes dhikr manually, reset currentPhase to "Tasbih"
        currentPhase = "Tasbih"
        dhikrCount = 0
    }

    var dhikrCount by mutableStateOf(0)
        private set

    var totalDhikrCount by mutableStateOf(0)
        private set

    var subhanCount by mutableStateOf(0)
        private set

    var alhamdCount by mutableStateOf(0)
        private set

    var allahCount by mutableStateOf(0)
        private set

    var laIlallahCount by mutableStateOf(0)
        private set

    var astaghCount by mutableStateOf(0)
        private set

    var currentPhase by mutableStateOf("Tasbih")

    fun afterSalahIncrement() {
        when (currentPhase) {
            "Tasbih" -> {   // first time user starts After Salah
                currentPhase = "SubhanAllah"
                dhikrCount = 0
            }

            "SubhanAllah" -> {
                afterSalahCounter()
                if (dhikrCount >= 34) {
                    currentPhase = "Alhamdulillah"
                    dhikrCount = 0
                }
            }

            "Alhamdulillah" -> {
                afterSalahCounter()
                if (dhikrCount >= 34) {
                    currentPhase = "Allahu Akbar"
                    dhikrCount = 0
                }
            }

            "Allahu Akbar" -> {
                afterSalahCounter()
                if (dhikrCount >= 34) {
                    currentPhase = "Completed"
                    dhikrCount = 0
                }
            }
        }
    }

    fun afterSalahCounter() {
        dhikrCount++
    }

    // progress tracking functions stay same...
    fun subhanallahIncrement() { dhikrCount++; totalDhikrCount++; subhanCount++ }
    fun alhamdulilahIncrement() { dhikrCount++; totalDhikrCount++; alhamdCount++ }
    fun allahuakbarIncrement() { dhikrCount++; totalDhikrCount++; allahCount++ }
    fun laIlallahIncrement() { dhikrCount++; totalDhikrCount++; laIlallahCount++ }
    fun astaghfirulahIncrement() { dhikrCount++; totalDhikrCount++; astaghCount++ }

    fun increment() { dhikrCount++; totalDhikrCount++ }

    fun reset() {
        dhikrCount = 0
        // 👇 keep phase reset consistent
        if (selectedDhikr.value == "After Salah") {
            currentPhase = "Tasbih"
        } else {
            currentPhase = "Tasbih"
        }
    }
}
