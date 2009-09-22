/*
 * Qualipso Funky Factory
 * Copyright (C) 2006-2010 INRIA
 * http://www.inria.fr - molli@loria.fr
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation. See the GNU
 * Lesser General Public License in LGPL.txt for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *
 * Initial authors :
 *
 * Jérôme Blanchard / INRIA
 * Christophe Bouthier / INRIA
 * Pascal Molli / Nancy Université
 * Gérald Oster / Nancy Université
 */
package org.qualipso.funkyfactory.ui.clock.server;

import javax.ejb.EJB;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.funkyfactory.service.clock.ClockService;
import org.qualipso.funkyfactory.service.clock.ClockServiceException;
import org.qualipso.funkyfactory.ui.clock.client.ClockServlet;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Implementation of the ClockService RPC service.
 * 
 * @author <a href="mailto:christophe.bouthier@loria.fr">Christophe Bouthier</a>
 * @date 16 September 2009
 */
@SuppressWarnings("serial")
public class ClockServletImpl extends RemoteServiceServlet implements ClockServlet {
    @EJB(mappedName = "ClockService")
    private ClockService clock;

    private static Log logger = LogFactory.getLog(ClockServletImpl.class);

    public String getTime() {
        String serverTime = "";

        logger.info("time: " + serverTime);
        try {
            serverTime = clock.getTime();
        } catch (ClockServiceException e) {
            logger.error("ClockServiceException");
            logger.error(e.getMessage(), e);
        }

        return serverTime;
    }
}
