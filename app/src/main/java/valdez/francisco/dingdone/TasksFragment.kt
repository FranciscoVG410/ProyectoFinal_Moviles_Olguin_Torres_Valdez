package valdez.francisco.dingdone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TasksFragment : Fragment() {

    private lateinit var taskList: RecyclerView
    private lateinit var emptyText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.activity_tasks, container, false)
//
//        taskList = view.findViewById(R.id.recyclerViewTasks)
//        emptyText = view.findViewById(R.id.emptyText)
//
//        val dummyTasks = listOf(
//            Task("Lavar platos", "Lavar todos los platos que se usaron en la mañana", listOf(UserData("Juan"), UserData("Francisco"), UserData("Victor")), "Lunes", "completada"),
//            Task("Sacar la basura", "Sacar la basura antes de las 10 porque llega el camión", listOf(UserData("Juan"), UserData("Francisco"), UserData("Victor")), "Lunes", "completada"),
//            Task("Lavar los carros", "Lavar el Eclipse del Beto porque se enoja si no", listOf(UserData("Juan"), UserData("Francisco"), UserData("Victor")), "Lunes", "pendiente"),
//            Task("Revisar el correo", "Lavar correos inventados para probar longitud", listOf(UserData("Juan"), UserData("Amos")), "Lunes", "pendiente")
//        )
//
//        if (dummyTasks.isEmpty()) {
//            emptyText.visibility = View.VISIBLE
//            taskList.visibility = View.GONE
//        } else {
//            emptyText.visibility = View.GONE
//            taskList.visibility = View.VISIBLE
//            taskList.layoutManager = LinearLayoutManager(requireContext())
//            taskList.adapter = TaskDateAdapter(dummyTasks, this.requireContext())
//        }

        return view
    }
}


