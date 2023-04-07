package com.neusoftwjj.crm.workbench.contacts.service.Impl;

import com.neusoftwjj.crm.workbench.contacts.mapper.ContactsMapper;
import com.neusoftwjj.crm.workbench.contacts.model.Contacts;
import com.neusoftwjj.crm.workbench.contacts.service.ContactsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("contactsService")
public class ContactsServiceImpl implements ContactsService {
    @Resource
    private ContactsMapper contactsMapper;
    @Override
    public List<Contacts> queryContactsAll() {
        return contactsMapper.selectContactsAll();
    }
}
