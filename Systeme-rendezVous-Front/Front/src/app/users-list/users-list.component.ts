import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../user_service/user.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  users!: User[];
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getlistuser();
  }

  private getlistuser(){
    this.userService.getUsersList().subscribe(data=>{
      this.users=data;
    })
  }
  deleteUser(id: number){
    this.userService.deleteUser(id).subscribe(data=>{
      console.log(data);
      this.getlistuser();
    })
  }
}
