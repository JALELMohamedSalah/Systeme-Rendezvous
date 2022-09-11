import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rendezvous } from '../models/rendezvous';
import { User } from '../models/user';
import { RendezvousService } from '../rendezvous.service';

@Component({
  selector: 'app-rendezvous-detail',
  templateUrl: './rendezvous-detail.component.html',
  styleUrls: ['./rendezvous-detail.component.css']
})
export class RendezvousDetailComponent implements OnInit {

/*  @Input() currentRdv: Rendezvous = {
    nom_client: '',
    prenom_client: '',
    commentaire: '',
    numtel = 0,
    etat: false,
    idRdv: 0,
    date_rdv: undefined,
    user: new User*/
 // };
  
 // message = '';
  id!: number;
  rendezvous!: Rendezvous;
  constructor(private route :ActivatedRoute, private rdvService: RendezvousService) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id']; 
    this.rendezvous=new Rendezvous()
    this.rdvService.getRdvById(this.id).subscribe(data=>{
      this.rendezvous=data;
    })
  }

  /*updateEtat(status: boolean): void {
    const data = {
      nomc: this.currentRdv.nom_client,
      prenomc: this.currentRdv.prenom_client,
      etat: status
    };

    this.message = '';

    this.rdvService.updateRendezvous(this.currentRdv.idRdv, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.currentRdv.etat = status;
          //this.message = res.message ? res.message : 'The status was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }*/

}
