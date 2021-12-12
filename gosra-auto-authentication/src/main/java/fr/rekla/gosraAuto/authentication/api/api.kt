package fr.rekla.gosraAuto.authentication.api

import org.axonframework.modelling.command.TargetAggregateIdentifier

// Commands

data class UserCreateCommand(@TargetAggregateIdentifier val id: String, val username: String)
data class UserUpdateCommand(@TargetAggregateIdentifier val id: String)
data class UserActivateCommand(@TargetAggregateIdentifier val id: String)
data class UserSuspendCommand(@TargetAggregateIdentifier val id: String)

// Events

data class UserCreatedEvent(@TargetAggregateIdentifier val id: String, val username: String)
data class UserUpdatedEvent(@TargetAggregateIdentifier val id: String)
data class UserActivatedEvent(@TargetAggregateIdentifier val id: String)
data class UserSuspendedEvent(@TargetAggregateIdentifier val id: String)