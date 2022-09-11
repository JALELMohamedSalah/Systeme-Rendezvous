import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Rendezvous } from '../models/rendezvous';
import { RendezvousService } from '../rendezvous.service';

@Component({
  selector: 'app-update-rendezvous',
  templateUrl: './update-rendezvous.component.html',
  styleUrls: ['./update-rendezvous.component.css']
})
export class UpdateRendezvousComponent implements OnInit {

  constructor(private rendezvousService: RendezvousService,private route:ActivatedRoute
    ,private router:Router) { }

  rendezv: Rendezvous= new Rendezvous();
  id!: number;
  ngOnInit(): void {
    this.id=this.route.snapshot.params[`id`];
    this.rendezvousService.getRdvById(this.id).subscribe(data=>{
      this.rendezv=data;
    },error=>console.log(error));
  }

  onSubmit(){
    this.rendezvousService.updateRendezvous(this.id,this.rendezv).subscribe(data=>{
this.goToRdvList();
    },error=>console.log(error));
  }

  goToRdvList(){
    this.router.navigate(['/admin']);
  }

}
