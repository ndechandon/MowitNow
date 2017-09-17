package service

import data.{Field, Mower, Position}
import exceptions.CreationImpossibleException

case class MowerBuilder( var field:Option[Field]=None,var position:Option[Position]=None,var order:Option[String]=None) {

    def withField(field: Field):Unit={
      this.field=Some(field)
    }

    def withPosition(position: Position):Unit={
      this.position=Some(position)
    }

    def withorder(order: String):Unit={
      this.order=Some(order)
    }

    @throws(classOf[CreationImpossibleException])
    def build():Mower= {
      if (this.field.get.controlPresencePositionOnFiled(this.position.get)){
        Mower(this.field.get,this.position.get,this.order.get)
      }else throw new CreationImpossibleException
    }

    def completed():Boolean ={
      if (this.position != None && this.field != None && this.order!= None ) true
      else false
    }

    def clean():Unit={
      this.position=None;
      this.order=None
    }

}
