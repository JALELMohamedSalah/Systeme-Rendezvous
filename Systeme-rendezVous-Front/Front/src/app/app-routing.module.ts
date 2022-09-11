import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { CreateRendezvousComponent } from './create-rendezvous/create-rendezvous.component';
import { UpdateRendezvousComponent } from './update-rendezvous/update-rendezvous.component';
import { UsersListComponent } from './users-list/users-list.component';
import { RendezvousDetailComponent } from './rendezvous-detail/rendezvous-detail.component';
const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {path: 'create-rendezvous', component:CreateRendezvousComponent},
  {path: 'update-rendezvous/:id',component:UpdateRendezvousComponent},
  {path: 'listUsers', component:UsersListComponent},
  {path: 'rendezvous-detail/:id', component: RendezvousDetailComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }