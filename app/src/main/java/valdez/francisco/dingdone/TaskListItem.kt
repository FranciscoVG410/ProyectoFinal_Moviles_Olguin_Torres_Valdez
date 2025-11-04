package valdez.francisco.dingdone

sealed class TaskListItem {

    data class Header(val dia: String) : TaskListItem()
    data class TaskItem(val task: Task) : TaskListItem()

}