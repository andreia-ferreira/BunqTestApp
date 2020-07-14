package pt.andreia.bunqtest.utils.mapping

import pt.andreia.bunqtest.model.UserEntity
import pt.andreia.bunqtest.model.dto.user.UserPerson

object UserMapper {

    fun mapUser(input: UserPerson): UserEntity {
        return UserEntity(
            userId = input.id ?: 0,
            name = input.displayName ?: "",
            billingAccountId = input.customer?.billingAccountId ?: 0
        )
    }
}