package valdez.francisco.dingdone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(var nombre: String, var descripcio: String, var member: List<UserData>, var date: String, var state: String): Parcelable
