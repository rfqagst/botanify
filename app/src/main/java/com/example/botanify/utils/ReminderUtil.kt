import com.example.botanify.data.firebase.model.Reminder
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun formatReminder(reminder: Map<String, Reminder>): String {
    val reminder1 = reminder["reminder1"]
    return if (reminder1 != null) {
        val time = reminder1.time.replace(":", ".")
        val nearestDate = getNearestDate(reminder1.dates)
        val formattedDate = formatDate(nearestDate)
        "$time, $formattedDate"
    } else {
        "No reminder set"
    }
}

fun getNearestDate(dates: List<String>): String {
    val inputFormat = SimpleDateFormat("MM-dd", Locale.getDefault())
    val currentDate = Calendar.getInstance().time

    var nearestDate: Date? = null
    var minDiff: Long = Long.MAX_VALUE

    for (dateStr in dates) {
        val date = inputFormat.parse(dateStr)
        if (date != null) {
            val diff = date.time - currentDate.time
            if (diff in 0..<minDiff) {
                minDiff = diff
                nearestDate = date
            }
        }
    }

    return if (nearestDate != null) {
        inputFormat.format(nearestDate)
    } else {
        dates.first()
    }
}

fun formatDate(date: String): String {
    val inputFormat = SimpleDateFormat("MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d MMMM", Locale.getDefault())
    val dateObj = inputFormat.parse(date)
    return outputFormat.format(dateObj)
}