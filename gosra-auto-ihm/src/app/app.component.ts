import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'gosra-auto-ihm';
  public toto$: Observable<any> = of(null);
  constructor(private http: HttpClient) {}


  getEvents() {
    this.toto$ = this.http.get("http://gosra-auto.dz/api/users/events/a5649a86-96cb-4935-af75-3ea0978e1ac3");
  }

  ngOnInit(): void {
    this.getEvents();
  }
}
