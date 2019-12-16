package com.vicky7230.cambio.data

import com.vicky7230.cambio.data.db.DbHelper
import com.vicky7230.cambio.data.network.ApiHelper

interface DataManager : ApiHelper, DbHelper {
}