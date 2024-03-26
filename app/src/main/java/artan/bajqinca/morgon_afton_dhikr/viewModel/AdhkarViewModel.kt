import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.content.Context
import artan.bajqinca.morgon_afton_dhikr.model.AdkarModel

class AdhkarViewModel(private val context: Context) : ViewModel() {
    private val dataParser = DataParser(context)

    private val _eveningAdhkarList = MutableStateFlow<List<AdkarModel>>(emptyList())
    private val _morningAdhkarList = MutableStateFlow<List<AdkarModel>>(emptyList())
    val eveningAdhkarList: StateFlow<List<AdkarModel>> = _eveningAdhkarList
    val morningAdhkarList: StateFlow<List<AdkarModel>> = _morningAdhkarList

    init {
        loadEveningAdhkarList()
        loadMorningAdhkarList()
    }

    private fun loadEveningAdhkarList() {
        viewModelScope.launch {
            _eveningAdhkarList.value = dataParser.getEveningAdhkarList()
        }
    }

    private fun loadMorningAdhkarList() {
        viewModelScope.launch {
            _morningAdhkarList.value = dataParser.getMorningAdhkarList()
        }
    }
}
