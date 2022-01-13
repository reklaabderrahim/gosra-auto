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
    this.toto$ = this.http.get("http://localhost:8888/api/users/events/27d73e30-d580-4a37-809b-41e92f19eee9");
  }

  ngOnInit(): void {
    this.getEvents();
  }
}
