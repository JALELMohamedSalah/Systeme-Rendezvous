import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Rendezvous } from '../models/rendezvous';
import { User } from '../models/user';
import { RendezvousService } from '../rendezvous.service';

@Component({
  selector: 'app-create-rendezvous',
  templateUrl: './create-rendezvous.component.html',
  styleUrls: ['./create-rendezvous.component.css']
})
export class CreateRendezvousComponent implements OnInit {

  rendezvous: Rendezvous= new Rendezvous();
  usr:User=new User();
  constructor(private rendezvousService: RendezvousService,private router: Router) { }

  ngOnInit(): void {
  }

  saveRendezVous(){
    this.rendezvousService.createRendezvous(this.rendezvous).subscribe(data=>{
         console.log(data);
         this.goToRendezvousList();
        
    }, 
    error=>console.log(error));
  }

  goToRendezvousList(){
this.router.navigate(['admin']);
  }
  onSubmit(){
console.log(this.rendezvous);
this.saveRendezVous();
  }
}
