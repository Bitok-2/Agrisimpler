package com.enock.agrisimpler.navigation


const val ROUT_START = "start"
const val ROUT_DASHBOARD = "dashboard"
const val ROUT_MANAGEMENT = "management"
const val ROUT_WEATHER = "weather"
const val ROUT_ANALYSIS = "analysis"
const val ROUT_IRRIGATION = "irrigation"
const val ROUT_MARKET = "market"
const val ROUT_NOTIFICATION = "notification"
const val ROUT_COMMUNITY = "community"
const val ROUT_WELCOME = "welcome"
const val ROUT_SPLASH = "splash"
const val ROUT_SERVICE = "service"


//Authentication
const val ROUT_REGISTER = "Register"
const val ROUT_LOGIN = "Login"

//Products

const val ROUT_ADD_PRODUCT = "add_product"
const val ROUT_PRODUCT_LIST = "product_list"
const val ROUT_EDIT_PRODUCT = "edit_product/{productId}"
const val ROUT_ADMINADDPRODUCT= "edit_product/{productId}"

// ✅ Helper function for navigation
fun editProductRoute(productId: Int) = "edit_product/$productId"

