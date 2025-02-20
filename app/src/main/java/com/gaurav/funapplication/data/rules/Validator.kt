package com.gaurav.funapplication.data.rules

object Validator {

    fun validateFirstName(fName: String): ValidationResults {
        return ValidationResults(
            (fName.isNotEmpty() && fName.length >= 4)
        )
    }
    fun validateLastName(lName: String): ValidationResults {
        return ValidationResults(
            (lName.isNotEmpty() && lName.length >= 4)
        )
    }
    fun validateEmail(email: String): ValidationResults {
        return ValidationResults(
            (email.isNotEmpty())
        )
    }
    fun validatePassword(password: String): ValidationResults {
        return ValidationResults(
            (password.isNotEmpty() && password.length >= 6)
        )
    }
    fun validatePrivacyPolicyAcceptance(statusValue: Boolean): ValidationResults {
        return ValidationResults(
            statusValue
        )
    }
}

data class ValidationResults(
    val status:Boolean = false
)