/**
 * Как получить application context
 * https://gist.github.com/paraya3636/bf8108a75eb49323e56c0c90dd0747e0
 *
 *
 * Справочник по операторам и ключевым словам
 * https://kotlinlang.org/docs/reference/keyword-reference.html
 */

package metro.moscow.troykacash

import android.app.Application
import android.content.Context
import android.os.Environment
import metro.moscow.troykacash.dao.FileHelper
import metro.moscow.troykacash.dao.NfcHelper
import metro.moscow.troykacash.utils.SharedData
import java.io.File

class TroykaCashApp : Application() {

    val fileHelper = FileHelper.instance
    val nfcHelper = NfcHelper.instance

    init {
        // Прикольно. Это инициализация локальной статичекой переменной instance,
        // которая живет в companion object
        instance = this
    }

    companion object {
        private var instance: TroykaCashApp? = null

        fun applicationContext() : Context {
            // https://kotlinlang.org/docs/reference/null-safety.html#the--operator
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}