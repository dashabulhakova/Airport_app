package com.solvd.airport.services;

import com.solvd.airport.DAO.MemberDAO;
import com.solvd.airport.models.MemberCard;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.solvd.airport.utils.ParserDOM;

import java.sql.SQLException;

public class MemberService implements IMemberService {
    private static final Logger LOGGER = Logger.getLogger(MemberService.class.getName());
    private MemberDAO memberDAO;
    private ParserDOM parseMember;

    @Override
    public void dataParse(String schema, String xmlFile) {
        parseMember.validate(schema);
        Document doc = parseMember.validate(xmlFile);
        NodeList list = doc.getElementsByTagName("level");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element element = (Element) node;
                MemberCard member = new MemberCard();
                member.setId(Integer.parseInt(element.getAttribute("id")));
                member.setLevel(element.getElementsByTagName("level").item(0).getTextContent());
                member.setYearsAsMember(Integer.parseInt(element.getElementsByTagName("years as member").item(0).getTextContent()));

                try {
                    memberDAO.createMember(member);
                } catch (SQLException e) {
                    LOGGER.warn(e.getMessage());
                }
            }
        }
    }
}

