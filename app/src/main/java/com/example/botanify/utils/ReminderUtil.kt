import android.os.Build
import androidx.annotation.RequiresApi
import com.example.botanify.data.firebase.model.Reminder
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
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

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateTime(dateTimeStr: String): String {
    // Define the input and output format
    val inputFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME
    val outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

    // Parse the input date string to ZonedDateTime
    val zonedDateTime = ZonedDateTime.parse(dateTimeStr, inputFormatter)

    // Format the ZonedDateTime to the desired format
    return zonedDateTime.format(outputFormatter)
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