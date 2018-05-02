import { Component, OnInit } from '@angular/core';
import {Message} from '../entity/message';
import {Observable} from 'rxjs/Observable';
import {DataService} from '../service/data-service';

@Component({
  selector: 'app-user-message',
  templateUrl: './user-message.component.html',
  styleUrls: ['./user-message.component.css']
})
export class UserMessageComponent implements OnInit {
  messages: Message[];
  constructor(public dataService: DataService) { }

  ngOnInit() {
      this.dataService.getMessages().subscribe((res:any)=>{
        this.messages.push(res);
      })
  }

}
