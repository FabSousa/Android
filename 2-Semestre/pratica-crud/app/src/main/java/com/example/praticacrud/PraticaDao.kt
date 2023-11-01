
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PraticaDao {
    @Insert
    fun insert(historyEntity: PraticaEntity)

    @Query("Select * from `pratica-table`")
    fun fetchALlDates(): Flow<List<PraticaEntity>>
}