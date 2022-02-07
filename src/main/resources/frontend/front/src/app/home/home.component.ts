import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subject, Subscription } from 'rxjs';
import { ListSheepComponent } from '../list-sheep/list-sheep.component';
import { SheepService } from '../services/sheep.services';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  sheeps:any[] = [];
  public idx:number = 0;
  sheepSubscription!:Subscription;

  constructor(private sheepService:SheepService,public listComponent:ListSheepComponent) { }

  ngOnDestroy(): void {
    this.sheepSubscription.unsubscribe();
  }

  ngOnInit(): void {
    console.log("home subscribing");
    // Abonnement et mise à jour du tableau
    this.sheepSubscription = this.sheepService.sheepSubject.subscribe(
        (p: any) => {
        this.sheeps = p;
        }
    );        
    // Emission de la mise à jour du tableau
    this.sheepService.emitSheepSubject();          
    console.log("home subscribed");
    // Récupération de la base de donnée
    this.sheepService.getAllFromServer();
  }

}
