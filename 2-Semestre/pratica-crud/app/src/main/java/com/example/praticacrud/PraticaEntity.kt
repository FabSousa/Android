import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pratica-table")
data class PraticaEntity(
    @PrimaryKey
    val date:String
)