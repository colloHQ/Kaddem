import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit {

  
  constructor(private router: Router, private route: ActivatedRoute) { }

	// On SignIn link click
	onSignIn() {
	  this.router.navigate(['sign-in'], { relativeTo: this.route.parent });
	}


  ngOnInit(): void {
  }

}
