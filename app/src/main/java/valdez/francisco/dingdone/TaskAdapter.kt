package valdez.francisco.dingdone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
//        return TaskViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
//        val task = tasks[position]
//        holder.bind(task)
//    }
//
//    override fun getItemCount(): Int = tasks.size
//
//    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
//        private val descriptionTextView: TextView = itemView.findViewById(R.id.textViewDescription)
//
//        fun bind(task: Task) {
//            titleTextView.text = task.title
//            descriptionTextView.text = task.description
//        }
//    }
//}