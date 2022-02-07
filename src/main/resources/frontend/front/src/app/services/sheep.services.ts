import { Injectable, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Subject, Subscription } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SheepService{
    private url = "http://localhost:8080/WS/sheep/";
    private sheep:any[] = [];
    private idx:number = 0;

    public sheepSubject = new Subject();

    constructor(private httpClient:HttpClient){}

    addSheep() {
        let r;
    //   const headers = { 'content-type': 'application/json'}  
    //   let r ={
    //     "client": {"clientId": clientSelect},
    //     "sceance": {"sceanceId": sceanceSelect},
    //     "nombrePlaces": nbPlaces,
    //     "reduction": "0"
    //   } 
      this.httpClient.post(this.url,r).subscribe(
        (response) =>{
          this.getAllFromServer();
          console.log (response)}
      );
    }

    // async sheepSubscribe(sheepSubscription:Subscription):Promise<any[]>{
    //     let app:any[] = [];
    //     // Récupération de la base de donnée
    //     this.getAllFromServer().then(()=>{
    //     // Abonnement et mise à jour du tableau
    //     sheepSubscription = this.sheepSubject.subscribe(
    //         (p: any) => {
    //         app = p;
    //         }
    //     );        
    //     // Emission de la mise à jour du tableau
    //     this.emitSheepSubject();
    //       }
    //     );

    //     return app;
    // }

    emitSheepSubject(){
        this.sheepSubject.next(this.sheep);
        console.log(this.sheep);
    }

    async getAllFromServer(){      
        this.httpClient.get<any[]>(this.url,{responseType:'json'}).subscribe(
          response => {
            if(response != undefined){
              this.idx=0;
              this.sheep = [];
              for(let o of response){
                this.idx++; 
                this.sheep.push(o);
              }
            }
            this.emitSheepSubject();
          });
    }
}