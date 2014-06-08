package controllers

import models.Task
import play.api.mvc._

import play.api.data._
import play.api.data.Form

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.tasks)
  }

  def tasks = Action {

    val taskForm = Form(
      "label" -> Forms.nonEmptyText
    )

    Ok(views.html.index(Task.all(), taskForm))
  }

  def newTask = TODO

  def deleteTask(id: Long) = TODO

}