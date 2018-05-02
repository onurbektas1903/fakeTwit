import { Component, OnInit } from '@angular/core';
import {Message} from '../entity/message';
import {DataService} from '../service/data-service';

@Component({
  selector: 'app-user-message',
  templateUrl: './user-message.component.html',
  styleUrls: ['./user-message.component.css']
})
export class UserMessageComponent implements OnInit {
  messages: Message[];
  formValue:string;
  constructor(public dataService: DataService) { }

  ngOnInit() {
   this.listMessages();
  }
  sendMessage(){
    let msg =new Message();
    let userName =localStorage.getItem("currentUser");
    msg.sendBy = userName;
    msg.message = this.formValue;
    this.dataService.sendMessage(msg).subscribe((resp)=>{
      this.formValue="";
        this.dataService.getMessages();
      this.listMessages();


    });
  }
  public listMessages(){
    this.dataService.getMessages().subscribe((res:any)=>{
      this.messages =res;
    });
  }
}
