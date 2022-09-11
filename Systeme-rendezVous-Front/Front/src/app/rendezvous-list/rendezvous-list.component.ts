import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Rendezvous } from '../models/rendezvous';
import { RendezvousService } from '../rendezvous.service';

@Component({
  selector: 'app-rendezvous-list',
  templateUrl: './rendezvous-list.component.html',
  styleUrls: ['./rendezvous-list.component.css']
})
export class RendezvousListComponent implements OnInit {
  rdv!: any[];

  constructor(private rendezvousService:RendezvousService,private router: Router) { }

  ngOnInit(): void {
    
    this.getRendezvous();
  }

  private getRendezvous(){
    this.rendezvousService.getRendezVousList().subscribe(data=>{
      this.rdv=data;

      console.log(data);
    });
  }

  updateRendezvous(idRdv: number){

    this.router.navigate(['update-rendezvous',idRdv]);
  }

  deleteRendezvous(idRdv: number){
    this.rendezvousService.deleteRendezvous(idRdv).subscribe(data=>{
      console.log(data);
      this.getRendezvous();
    })
  }

  RendezvousDetails(idRdv: number){
    this.router.navigate(['rendezvous-detail',idRdv]);

  }

}
