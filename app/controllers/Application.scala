package controllers

import models.Task
import play.api.mvc._

import play.api.data._
import play.api.data.Form

object Application extends Controller {

  val taskForm = Form(
      "label" -> Forms.nonEmptyText
    )

  def index = Action {
    Redirect(routes.Application.tasks)
  }

  def tasks = Action {

    Ok(views.html.index(Task.all(), taskForm))
  }

  def newTask = Action {implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.Application.tasks)
      }
    )
  }

  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }

}