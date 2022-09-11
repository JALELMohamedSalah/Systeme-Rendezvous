import { Component, OnInit, OnDestroy } from '@angular/core';
import { StorageService } from './_services/token-storage.service';
import { AuthService } from './_services/auth.service';
import { EventBusService } from './_shared/event-bus.service.ts.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy{
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;

  showModeratorBoard = false;
  username?: string;
  eventBusSub?: Subscription;
  constructor(private storageService: StorageService, private authService: AuthService,private eventBusService: EventBusService) { }
  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();
    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      //this.showUserBoard = this.roles.includes('ROLE_AGENT');
      this.showModeratorBoard = this.roles.includes('ROLE_AGENT');
      this.username = user.username;
    
    }this.eventBusSub = this.eventBusService.on('logout', () => {
      this.logout();
    });
  }

  ngOnDestroy(): void {
    if (this.eventBusSub)
      this.eventBusSub.unsubscribe();
  }

  /*logout(): void {
    this.authService.logout().subscribe({
      next: res => {
        console.log(res);
        this.storageService.clean();
      },
      error: err => {
        console.log(err);
      }
    });
    
    window.location.reload();
  }*/

  logout(): void {
    this.storageService.signOut();
    this.isLoggedIn = false;
    this.roles = [];
    this.showAdminBoard = false;
    this.showModeratorBoard = false;
  }
}