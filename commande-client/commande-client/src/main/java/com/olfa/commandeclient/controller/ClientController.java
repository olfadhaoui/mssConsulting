package com.olfa.commandeclient.controller;

import com.olfa.commandeclient.entities.Client;
import com.olfa.commandeclient.models.ClientModel;
import com.olfa.commandeclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author olfa dhaoui
 *
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/clients")
public class ClientController extends  BaseController<Client, ClientModel,Long> {

}
