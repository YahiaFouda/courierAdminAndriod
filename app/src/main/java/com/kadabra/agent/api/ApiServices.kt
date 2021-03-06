package com.kadabra.agent.api


import android.app.Notification
import com.kadabra.agent.googleDirection.Directions
import com.kadabra.agent.model.*
import com.kadabra.agent.utilities.AppConstants
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by Mokhtar on 1/5/2020.
 */
interface ApiServices {


    @GET(AppConstants.URL_LOGIN)
    fun logIn(@Query("userName") userName: String, @Query("password") password: String, @Query("deviceType") deviceType: Int)
            : Call<ApiResponse<Admin>>


    @POST(AppConstants.URL_LOG_OUT)
    fun logOut(@Query("ID") id: Int)
            : Call<ApiResponse<Admin>>


    @GET(AppConstants.URL_GET_ALL_TICKETS)
    fun getAllTickets()
            : Call<ApiResponse<ArrayList<Ticket>>>

    @GET(AppConstants.URL_GET_ALL_TICKETS_BY_PAGE_NO)
    fun getAllTicketsByPage(@Query("Adminid") adminId: String,@Query("numOfItems") numOfItem: Int, @Query("pageNo") pageNo: Int)
            : Call<ApiResponse<TicketDataPerPage>>

    @GET(AppConstants.URL_GET_ALL_TICKETS_SIMPLE)
    fun getAllTicketsNormal(@Query("Adminid") adminId: String)
            : Call<ApiResponse<TicketData>>

    @GET(AppConstants.URL_GET_ALL_TICKETS_BY_PAGE_NO_SIMPLE)
    fun getAllTicketsByPageNormal(
        @Query("numOfItem") numOfItem: Int, @Query("pageNo") pageNo: Int, @Query(
            "Adminid"
        ) adminId: String
    )
            : Call<ApiResponse<ArrayList<Ticket>>>

    @POST(AppConstants.URL_GET_TICKET_BY_ID)
    fun getTicketById(
        @Query("ticketId") ticketId: String
    )
            : Call<ApiResponse<Ticket>>

    @GET(AppConstants.URL_TICKET_SUB_DATA)
    fun getTicketSubData()
            : Call<ApiResponse<data>>


    @POST(AppConstants.URL_ADD_TICKET)
    fun addTicket(
        @Body ticket: TicketModel
    )
            : Call<ApiResponse<Ticket>>

    @POST(AppConstants.URL_EDIT_TICKET)
    fun editTicket(
        @Body ticketAdd: TicketModel
    )
            : Call<ApiResponse<Ticket>>


    @GET(AppConstants.URL_TICKET_SUB_DATA)
    fun getAllTicketSubDetails(): Call<ApiResponse<data>>


    @POST(AppConstants.URL_ADD_TASK)
    fun addTask(
        @Body tasModel: TaskModel
    )
            : Call<ApiResponse<ArrayList<Task>>>


    @POST(AppConstants.URL_EDIT_TASK)
    fun editTask(
        @Body tasModel: TaskModelEdit
    )
            : Call<ApiResponse<ArrayList<Task>>>

    @POST(AppConstants.URL_CANCEL_TASK)
    fun cancelTask(
        @Query("taskId") taskId: String, @Query("amount") amount: Double
    )
            : Call<ApiResponse<Boolean?>>

    @POST(AppConstants.URL_REASSIGN_TASK_TO_COURIER)
    fun reAssignTaskToCourier(@Query("TaskId") taskId: String, @Query("CourierID") courierId: String)
            : Call<ApiResponse<Boolean>>

    @GET(AppConstants.URL_GET_ALL_COURIERS)
    fun getAllCouriers()
            : Call<ApiResponse<ArrayList<Courier>>>

    @GET(AppConstants.URL_GET_ALL_COURIERS_WITH_STATUS)
    fun getAllCouriersWithStatus()
            : Call<ApiResponse<ArrayList<Courier>>>

    @FormUrlEncoded
    @POST(AppConstants.URL_ADD_TASK_STOP)
    fun addTaskStop(
        @Field("AddedBy") addedBy: String,
        @Field("TaskId") taskId: String,
        @Field("Latitude") latitude: String,
        @Field("Longitude") longitude: String,
        @Field("StopName") stopName: String,
        @Field("StopTypeID") sopTypeID: Int,
        @Field("StopType") stopType: String,
        @Field("CreationDate") creationDate: String

    )
            : Call<ApiResponse<ArrayList<Stop>>>


    @POST(AppConstants.URL_GET_ALL_TASK_STOPS)
    fun getAllTaskStops(@Query("TaskId") taskId: String)
            : Call<ApiResponse<ArrayList<Stop>>>


    @POST(AppConstants.URL_REMOVE_TASK)
    fun removeTask(
        @Query("taskId") taskId: String,
        @Query("AdminId") adminId: String
    )
            : Call<ApiResponse<Any?>>


    @POST(AppConstants.URL_REMOVE_STOP)
    fun removeStop(
        @Query("stopId") stopId: String,
        @Query("AdminId") adminId: String
    )
            : Call<ApiResponse<ArrayList<Stop>>>

    @POST(AppConstants.URL_SET_USER_TOKEN)
    fun setAdminToken(@Query("adminId") adminId: String, @Query("Token") token: String)
            : Call<ApiResponse<Boolean>>


    @GET(AppConstants.URL_GET_VERSION_CODE)
    fun forceUpdate(): Call<ApiResponse<String>>

    @GET(AppConstants.URL_GET_TAKS_DETAILS)
    fun getTaskDetails(@Query("taskId") taskID: String)
            : Call<ApiResponse<Task>>

    ////////////////////////not implemented yet //////////////////
    @GET(AppConstants.URL_GET_ALL_COMPLETED_TASKS)
    fun getCompletedTasks()
            : Call<ApiResponse<ArrayList<Task>>>

    @GET(AppConstants.URL_GET_ALL_NOTIFICATIONS)
    fun getALlNotifications(@Query("adminId") adminId: String)
            : Call<ApiResponse<NotificationData>>

    @GET(AppConstants.URL_GET_ALL_READED_NOTIFICATIONS)
    fun updateReadedNotification(@Query("notificationId") notificationId: String)
            : Call<ApiResponse<ArrayList<Task>>>

    @GET(AppConstants.URL_GET_CLIENT_NAME)
    fun getClientName(@Query("mobile") mobileNo: String)
            : Call<ApiResponse<String?>>

    @POST(AppConstants.URL_TAG_AGENT_IN_TICKET)
    fun tagAgentInTicket(@Query("TicketId") ticketId: String, @Query("AgentId") agentId: String,@Query("TaggedAgentId") taggedAgentId:String)
            : Call<ApiResponse<Boolean>>


    @POST(AppConstants.URL_END_TAKS)
    fun endTask(@Query("taskId") taskID: String)
            : Call<ApiResponse<Task>>

    @GET("maps/api/directions/json")
    fun getFullJson(
        @Query("origin") origin: String, @Query("destination") destination: String,
        @Query("waypoints") waypoints: String?, @Query("key") key:String

    ): Call<Directions?>


/////////////////////////////////////////////


}

