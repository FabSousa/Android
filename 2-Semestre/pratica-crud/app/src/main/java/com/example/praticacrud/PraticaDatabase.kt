import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PraticaEntity::class], version = 1)
abstract class PraticaDatabase: RoomDatabase(){

    abstract fun praticaDao(): PraticaDao

    companion object {
        @Volatile
        private var INSTANCE: PraticaDatabase? = null

        fun getInstance(context: Context): PraticaDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, PraticaDatabase::class.java, "pratica_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}